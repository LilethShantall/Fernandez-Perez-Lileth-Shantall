package repository;

import model.Gasto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GastoRepository {

    private final String url;
    private final String user;
    private final String password;

    public GastoRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void save(Gasto gasto) {
        String sql = "INSERT INTO gastos (descripcion, categoria, monto, fecha_gasto) VALUES (?, ?, ?, ?)";
        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gasto.getDescripcion());
            statement.setString(2, gasto.getCategoria());
            statement.setDouble(3, gasto.getMonto());
            statement.setString(4, gasto.getFechaGasto());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el gasto", e);
        }
    }

    public List<Gasto> findAll() {
        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT * FROM gastos";
        try ( Connection connection = DriverManager.getConnection(url, user, password);  Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Gasto gasto = new Gasto(
                        resultSet.getInt("id"),
                        resultSet.getString("descripcion"),
                        resultSet.getString("categoria"),
                        resultSet.getDouble("monto"),
                        resultSet.getString("fecha_gasto")
                );
                gastos.add(gasto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los gastos", e);
        }
        return gastos;
    }

    public void update(Gasto gasto) {
        String sql = "UPDATE gastos SET descripcion = ?, categoria = ?, monto = ?, fecha_gasto = ? WHERE id = ?";

        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gasto.getDescripcion());
            statement.setString(2, gasto.getCategoria());
            statement.setDouble(3, gasto.getMonto());
            statement.setString(4, gasto.getFechaGasto());
            statement.setInt(5, gasto.getId());

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new RuntimeException("No se encontró el gasto para actualizar.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al editar el gasto", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM gastos WHERE id = ?";
        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el gasto", e);
        }
    }

    public double obtenerTotalMensual() {
        String sql = "SELECT SUM(monto) FROM gastos WHERE MONTH(fecha_gasto) = MONTH(CURDATE())";
        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(sql);  ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al calcular el total mensual de gastos", e);
        }
        return 0;
    }
}
