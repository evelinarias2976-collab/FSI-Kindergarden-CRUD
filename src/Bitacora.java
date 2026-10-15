
/**
 *
 * @author eveli
 */
import java.sql.*;

public class Bitacora {

    static String todos = "SELECT * FROM bitacora ORDER BY folio DESC";

    String folio, tiempo, tipo, observaciones, curpi, curpr, curpe;

    public Bitacora() {

    }

    public Bitacora(String folio, String tiempo, String tipo, String observaciones, String curpi, String curpr, String curpe) {
        this.folio = folio;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.observaciones = observaciones;
        this.curpi = curpi;
        this.curpr = curpr;
        this.curpe = curpe;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO bitacora VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, tiempo);
            ps.setString(3, tipo);
            ps.setString(4, observaciones);
            ps.setString(5, curpi);
            ps.setString(6, curpr);
            ps.setString(7, curpe);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM bitacora WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE bitacora SET tiempo = ?, tipo = ?, observaciones = ?, infantes_curp = ?, responsables_curpr = ?, educadores_curpe = ?, WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tiempo);
            ps.setString(2, tipo);
            ps.setString(3, observaciones);
            ps.setString(4, curpi);
            ps.setString(5, curpr);
            ps.setString(6, curpe);
            ps.setString(7, folio);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return resultado;
        }
    }
}
