package org.uv.dapp02practica01;
import java.util.List;

/**
 *
 * @author Codigy
 * @param <T>
 */
public interface IDAO<T> {
    public boolean guardar(T p);
    public boolean modificar(T p);
    public boolean eliminar(T p);
    public T buscarbyId(int id);
    public List<T> buscarAll();
}
