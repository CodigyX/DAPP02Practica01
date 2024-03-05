package org.uv.dapp02practica01;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * DAO for handling Venta entities.
 * 
 * @author Codigy
 */
public class DAOVenta implements IDAO<Venta> {

    private final ConexionDB con;

    public DAOVenta() {
        this.con = ConexionDB.getInstance();
    }

    @Override
    public boolean guardar(Venta pojo) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pojo);
            transaction.commit();
            System.out.println("Se guardó con el id " + pojo.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(Venta pojo) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(pojo);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modificar(Venta pojo) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Venta existingVenta = session.get(Venta.class, pojo.getId());
            if (existingVenta != null) {
                existingVenta.setCliente(pojo.getCliente());
                existingVenta.setFecha(pojo.getFecha());
                existingVenta.setTotal(pojo.getTotal());
                existingVenta.setDetalleVenta(pojo.getDetalleVenta());
                session.update(existingVenta);
                transaction.commit();
                return true;
            } else {
                // Handle case where the entity doesn't exist
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Venta buscarById(Integer id) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Venta vent = session.get(Venta.class, id);
            transaction.commit();
            return vent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Venta> buscarAll() {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<Venta> ventas = session.createQuery("FROM Venta").list();
            transaction.commit();
            return ventas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Venta buscarbyId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}