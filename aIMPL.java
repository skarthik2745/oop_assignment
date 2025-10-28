package oops4;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ArithmeticImpl extends UnicastRemoteObject implements ArithmeticInterface {

    protected ArithmeticImpl() throws RemoteException {
        super();
    }

    private void saveToDB(double a, double b, String operation, double result) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO operations (operand1, operand2, operation, result) VALUES (?, ?, ?, ?)"
            );
            ps.setDouble(1, a);
            ps.setDouble(2, b);
            ps.setString(3, operation);
            ps.setDouble(4, result);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double add(double a, double b) throws RemoteException {
        double result = a + b;
        saveToDB(a, b, "Addition", result);
        return result;
    }

    public double subtract(double a, double b) throws RemoteException {
        double result = a - b;
        saveToDB(a, b, "Subtraction", result);
        return result;
    }

    public double multiply(double a, double b) throws RemoteException {
        double result = a * b;
        saveToDB(a, b, "Multiplication", result);
        return result;
    }

    public double divide(double a, double b) throws RemoteException {
        if (b == 0) throw new RemoteException("Division by zero not allowed.");
        double result = a / b;
        saveToDB(a, b, "Division", result);
        return result;
    }
}
