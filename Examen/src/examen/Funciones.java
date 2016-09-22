package examen;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Funciones extends JFrame{
     JTextField superior;
    JButton n1, n2, n3, n4, n5, n6, n7, n8, n9, ce, convertir;
    JPanel nums, oper;
    double resultado, res2;
    boolean reiniciar=true;
    String numoperacion;
    
    public Funciones(){
        
        super();
	setSize(280, 300);
        //setLocation(0,0);
	setResizable(false);
        setTitle("Convertidor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
        JPanel panelp = (JPanel) this.getContentPane();
		panelp.setLayout(new BorderLayout());
                
                superior = new JTextField(" ", 20);
		superior.setFont(new Font("Century Gothic", Font.BOLD, 20));
                //superior.setBorder(new EmptyBorder(4, 4, 4, 4));
		superior.setHorizontalAlignment(JTextField.RIGHT);
		superior.setEditable(false);
		superior.setBackground(Color.white);
		panelp.add("North", superior);

		nums = new JPanel();
		nums.setLayout(new GridLayout(4, 3));
		//puede faltar el empty border nums.setBorder(new EmptyBorder(4, 4, 4, 4));
                
                for (int n = 9; n >= 0; n--) {
			convertir= new JButton("" + n);
                        convertir.setFont(new Font("Century Gothic", Font.BOLD, 12));
		}
                newnum("1");
                newnum("2");
                newnum("3");
                newnum("4");
                newnum("5");
                newnum("6");
                newnum("7");
                newnum("8");
                newnum("9");
                newnum("0");
		newnum(".");
                

		panelp.add("Center", nums);
                
                oper = new JPanel();
                
		oper.setLayout(new GridLayout(2, 1));
		//oper.setBorder(new EmptyBorder(4, 4, 4, 4));
		newoper("Convertir");
                newoper("CE");
        	panelp.add("East", oper);

		validate();
                
    }   
    
        private void newnum(String digito) {
		JButton bot = new JButton();
		bot.setText(digito);
		bot.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton bot = (JButton) evt.getSource();
				numele(bot.getText());
			}
		});
		nums.add(bot);
	}
         private void calcularResultado() {
		if (numoperacion.equals("Convertir")) {
			resultado = new Double(superior.getText());       
                        res2=resultado*20;
                } 
                superior.setText("" + res2);
                //superior.setText("" + resultado);        
		numoperacion = "";
	}

	 private void newoper(String operacion) {
		JButton bot2 = new JButton(operacion);
		bot2.setForeground(Color.BLACK);

		bot2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton bot2 = (JButton) evt.getSource();
				eleoper(bot2.getText());
			}
		});

		oper.add(bot2);
	}

	private void numele(String digito) {
		if (superior.getText().equals("0") || reiniciar) {
			superior.setText(digito);
		} else {
			superior.setText(superior.getText() + digito);
		}
		reiniciar = false;
	}

	private void eleoper(String tecla) {
		if (tecla.equals("Convertir")) {
			calcularResultado();
		} else if (tecla.equals("CE")) {
			resultado = 0;
			superior.setText("");
			reiniciar = true;
		} else {
			numoperacion = tecla;
			if ((resultado > 0) && !reiniciar) {
				calcularResultado();
			} else {
                            resultado = new Double(superior.getText());    
                        }
		}

		reiniciar = true;
	}
}
