package stratego_marvel_proyecto_final;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.text.JTextComponent;
import javax.swing.JFrame;

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

    //Métodos de registro e inicio de sesión
    public static void registrarUsuario(FrmRegistroInicio form, String usuario, String contrasena) {

        if (utilidades.validarCampos(usuario, FrmRegistroInicio.placeholderUsuario,
                contrasena, FrmRegistroInicio.placeholderContrasena)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: Uno de los campos se encuentra vacío.");
            return;
        }

        if (contrasena.length() != 5) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: La contraseña debe tener exactamente 5 caracteres.");
            return;
        }

        for (int i = 0; i < DatosGlobales.listaJugadores.cantidad(); i++) {
            Jugador jugador = DatosGlobales.listaJugadores.obtener(i);
            if (jugador.getUsuario().equals(usuario)) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: Nombre de usuario registrado previamente.");
                return;
            }
        }

        DatosGlobales.listaJugadores.agregar(new Jugador(usuario, contrasena));
        javax.swing.JOptionPane.showMessageDialog(null, "Jugador creado correctamente.");
        FrmMenuInicial menuInicial = new FrmMenuInicial();
        menuInicial.setVisible(true);
        form.dispose();
        return;
    }

    public static void iniciarSesion(FrmRegistroInicio form, String usuario, String contrasena) {

        if (utilidades.validarCampos(usuario, FrmRegistroInicio.placeholderUsuario,
                contrasena, FrmRegistroInicio.placeholderContrasena)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: Uno de los campos se encuentra vacío.");
            return;
        }

        for (int i = 0; i < DatosGlobales.listaJugadores.cantidad(); i++) {
            Jugador jugador = DatosGlobales.listaJugadores.obtener(i);
            if (jugador.getUsuario().equals(usuario)) {
                if (jugador.getContrasena().equals(contrasena)) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                    FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal();
                    menuPrincipal.setVisible(true);
                    form.dispose();
                    return;
                }
            }
        }

        javax.swing.JOptionPane.showMessageDialog(null, "Error: usuario o contraseña incorrecta.");
    }

    public static boolean validarCampos(String textoCampo1, String placeholder1, String textoCampo2, String placeholder2) {
        return textoCampo1.trim().isEmpty() || textoCampo1.equals(placeholder1)
                || textoCampo2.trim().isEmpty() || textoCampo2.equals(placeholder2);
    }
}
