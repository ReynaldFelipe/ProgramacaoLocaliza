package Projeto_Localiza.Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost:3306/localiza";
    private static final String USER = "root";
    private static final String PASS = "mercy321"; // Troque pela senha do Workbench

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage());
        }
    }
}
