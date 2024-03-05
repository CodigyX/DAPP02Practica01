package org.uv.dapp02practica01;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author Codigy
 */
public class DAPP02Practica01 {

    public static void main(String[] args) {
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        
        Venta ven=new Venta();
        ven.setCliente("Public General");
        ven.setTotal(100.00);
        ven.setFecha(new java.sql.Date(new Date().getTime()));
        
        Transaction tran=session.beginTransaction();
        //Guarda encabezado
        session.save(ven);
        for(int i=0; i<5; i++){
            DetalleVenta det=new DetalleVenta();
            det.setCantidad(10);
            det.setPrecio(i);
            det.setProducto(producto);
            det.setVenta(ven);
        }
        
        tran.commit();
        
        System.out.println("Se guardo con el ID: "+ ven.getId());
//        public boolean guardar
//        try {
//            String url="jdbc:postgresql://localhost:5432/ejemplobd";
//            String pwd="123456";
//            String usr="postgres";
//            Connection con= DriverManager.getConnection(url,usr,pwd);
//          
//            Logger.getLogger(DAPP02Practica01.class.getName())
//                    .log(Level.INFO, "Se conecto!!!");
//        } catch (SQLException ex) {
//            Logger.getLogger(DAPP02Practica01.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//      IMensaje msg = new Saludo();
//
//      ControllerMensaje.MostrarMensaje(msg);
//          

//        IMensaje msg = new IMensaje(){
//            @Override
//            public void imprimir(){
//                System.out.println("Otro mensaje...");
//            }
//        };
//            ControllerMensaje.MostrarMensaje(msg);
    }
}
