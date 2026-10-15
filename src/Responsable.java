
/**
 *
 * @author eveli
 */
import java.sql.*;
public class Responsable {
    String curp, nombre, sexo, telefono, parentesco, estado;
    
    static String todos = "SELECT * FROM responsables ORDER BY nombrer";
    static String curps = "SELECT curpr FROM responsables ORDER BY curpr";
    
    
    public Responsable(){
        
    }

    public Responsable(String curp, String nombre, String sexo, String telefono, String parentesco, String estado) {
        this.curp = curp;
        this.nombre = nombre;
        this.sexo = sexo;
        this.telefono = telefono;
        this.parentesco = parentesco;
        this.estado = estado;
    }

    
    
    public int insertar(Connection con){
        int resultado=0;
        try {
            String sql = "INSERT INTO responsables VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curp);
            ps.setString(2, nombre);
            ps.setString(3, sexo);
            ps.setString(4, telefono);
            ps.setString(5, parentesco);
            ps.setString(6, estado);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
    
    public int borrar(Connection con){
        int resultado = 0;
        try {
            String sql = "DELETE FROM responsables WHERE curp = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curp);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
        
    }
    
    public int actualizar(Connection con){
        int resultado = 0;
        try {
            String sql = "UPDATE responsables SET nombrer=?, sexor=?, telefono=?, parentesco=?, estador=? WHERE curpr=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, sexo);
            ps.setString(3, telefono);
            ps.setString(4, parentesco);
            ps.setString(5, estado);
            ps.setString(5, curp);
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
    
}
