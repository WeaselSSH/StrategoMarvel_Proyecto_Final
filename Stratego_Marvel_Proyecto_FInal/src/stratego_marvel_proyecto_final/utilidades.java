package stratego_marvel_proyecto_final;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.text.JTextComponent;

public class utilidades {

    public static void agregarPlaceholder(JTextComponent campo, String placeholder) {
        Color colorPlaceholder = Color.gray;
        Color colorTexto = Color.black;

        char defaultEchoChar = (campo instanceof JPasswordField)
                ? ((JPasswordField) campo).getEchoChar()
                : (char) 0;

        if (campo instanceof JPasswordField pass) {
            pass.setEchoChar((char) 0);
        }

        campo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                String texto = campo instanceof JPasswordField
                        ? String.valueOf(((JPasswordField) campo).getPassword())
                        : campo.getText();

                if (texto.equals(placeholder)) {
                    campo.setText("");
                    campo.setForeground(colorTexto);

                    if (campo instanceof JPasswordField pass) {
                        pass.setEchoChar(defaultEchoChar);
                    }
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String texto = campo instanceof JPasswordField
                        ? String.valueOf(((JPasswordField) campo).getPassword())
                        : campo.getText();

                if (texto.isEmpty()) {
                    campo.setForeground(colorPlaceholder);
                    campo.setText(placeholder);

                    if (campo instanceof JPasswordField pass) {
                        pass.setEchoChar((char) 0);
                    }
                }
            }
        });
    }

    public static void registrarUsuario(String usuario, String contrasena) {

        if (utilidades.validarCampos(usuario, DatosGlobales.placeholderUsuario, contrasena, DatosGlobales.placeholderContrasena)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: Uno de los campos se encuentra vacío.");
            return;
        }

        if (contrasena.length() != 5) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: La contraseña debe tener exactamente 5 caracteres.");
            return;
        }

        if (DatosGlobales.jugadores.containsKey(usuario)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: Nombre de usuario registrado previamente.");
            return;
        }

        Jugador nuevoJugador = new Jugador(usuario, contrasena);
        DatosGlobales.jugadores.put(usuario, nuevoJugador);

        javax.swing.JOptionPane.showMessageDialog(null, "Jugador creado correctamente.");
    }

    public static void iniciarSesion(String usuario, String contrasena) {

        if (utilidades.validarCampos(usuario, DatosGlobales.placeholderUsuario, contrasena, DatosGlobales.placeholderContrasena)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: Uno de los campos se encuentra vacío.");
            return;
        }
        
        if (!DatosGlobales.jugadores.containsKey(usuario)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: Usuario no existe.");
            return;
        }
        
        Jugador jugador = DatosGlobales.jugadores.get(usuario);
        
        if (!Jugador.getContrasena().equals(contrasena)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: Usuario o contraseña incorrecta.");
            return;
        }

        javax.swing.JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
    }

    public static boolean validarCampos(String textoCampo1, String placeholder1, String textoCampo2, String placeholder2) {
        return textoCampo1.trim().isEmpty() || textoCampo1.equals(placeholder1)
                || textoCampo2.trim().isEmpty() || textoCampo2.equals(placeholder2);
    }
}
