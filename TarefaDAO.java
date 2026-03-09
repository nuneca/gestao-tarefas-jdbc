import java.sql.*;
import java.util.ArrayList;

public class TarefaDAO {

    public void criarTarefa(String titulo, String categoria) {

        String sql = "INSERT INTO tarefas (titulo, categoria, status) VALUES (?, ?, 'PENDENTE')";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            stmt.setString(2, categoria);

            stmt.executeUpdate();

            System.out.println("Tarefa criada!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarTarefas() {

        String sql = "SELECT * FROM tarefas";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("titulo") + " | " +
                        rs.getString("categoria") + " | " +
                        rs.getString("status")
                );

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void concluirTarefa(int id) {

        String sql = "UPDATE tarefas SET status='CONCLUIDA' WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Tarefa concluída!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void excluirTarefa(int id) {

        String sql = "DELETE FROM tarefas WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Tarefa removida!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filtrarCategoria(String categoria) {

        String sql = "SELECT * FROM tarefas WHERE categoria=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("titulo") + " | " +
                        rs.getString("categoria") + " | " +
                        rs.getString("status")
                );

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
