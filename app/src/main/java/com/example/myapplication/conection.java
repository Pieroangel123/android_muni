package com.example.myapplication;

import android.content.Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class conection {
    private Context context;

    public conection(Context context) {
        this.context = context;
    }
    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                String url="jdbc:postgresql://dpg-chc7f3u7avjcvo5o27gg-a.oregon-postgres.render.com:5432/msi";
                String user="admin";
                String password="26iPJphjZZj4wtG1uevAaXjv9H3VcPFW";

                Properties properties = new Properties();
                properties.setProperty("user", "admin");
                properties.setProperty("password", "26iPJphjZZj4wtG1uevAaXjv9H3VcPFW");
                properties.setProperty("ssl", "true");
                properties.setProperty("sslmode", "require");


                conn = DriverManager.getConnection(url, properties);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void insertPenalidad(String valorCheckBox1, String valorCheckBox2, String valorCheckBox3, String valorCheckBox4, String valorCheckBox5, String valorCheckBox6, String valorCheckBox7, String valorCheckBox8, String valorCheckBox9) {
        try {
            Connection connection = getConnection();

            // Preparar la sentencia SQL para la inserción en la tabla t_HojaRegistroD
            String sql = "INSERT INTO public.\"t_HojaRegistroD\" (\"Tiera/Papeles\", \"Embolsado\", \"Nivel Ejecucion\", \"Uniforme\", \"Herramientas\", \"Personal Comp\", \"Personal Idn\", \"EPP\", \"HoraR\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros de la sentencia SQL
            statement.setString(1, valorCheckBox1);
            statement.setString(2, valorCheckBox2);
            statement.setString(3, valorCheckBox3);
            statement.setString(4, valorCheckBox4);
            statement.setString(5, valorCheckBox5);
            statement.setString(6, valorCheckBox6);
            statement.setString(7, valorCheckBox7);
            statement.setString(8, valorCheckBox8);
            statement.setString(9, valorCheckBox9);

            // Ejecutar la sentencia SQL
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertDataIntoPenalidadTable(String direccion, String distrito, String referencia, String actividad, String ocurrencia, String item, String nomPenalidad, String obs, String nomSupPe, String apeSupPe, String dniSupPe, String correoSupPe, String celularSupPe, String obsPenalidad) {
        try {
            Connection connection = getConnection();

            // Preparar la sentencia SQL para la inserción en la tabla t_Penalidad
            String sql = "INSERT INTO public.\"t_Penalidad\" (\"Direccion\", \"Distrito\", \"Referencia\", \"Actividad\", \"Ocurrencia\", \"Item\", \"Nom_Penalidad\", \"Obs\", \"Nom_sup_Pe\", \"Ape_Sup_pe\", \"DNI_Sup_pe\", \"Correo_Sup_pe\", \"Celular_Sup_pe\", \"obs_Penalidad\", \"Comentarios\", \"Fecha\", \"Hora\", \"Estado\", \"Status\", \"Nom_Fis\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros de la sentencia SQL
            statement.setString(1, direccion);
            statement.setString(2, distrito);
            statement.setString(3, referencia);
            statement.setString(4, actividad);
            statement.setString(5, ocurrencia);
            statement.setString(6, item);
            statement.setString(7, nomPenalidad);
            statement.setString(8, obs);
            statement.setString(9, nomSupPe);
            statement.setString(10, apeSupPe);
            statement.setString(11, dniSupPe);
            statement.setString(12, correoSupPe);
            statement.setString(13, celularSupPe);
            statement.setString(14, obsPenalidad);
            statement.setString(15, "N/A"); // Comentarios
            statement.setString(16, "N/A"); // Fecha
            statement.setString(17, "N/A"); // Hora
            statement.setString(18, "N/A"); // Estado
            statement.setString(19, "N/A"); // Status
            statement.setString(20, "N/A"); // Nom_Fis

            // Ejecutar la sentencia SQL
            statement.executeUpdate();

            // Cerrar el statement y la conexión
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
