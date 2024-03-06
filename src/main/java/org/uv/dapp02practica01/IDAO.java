package org.uv.dapp02practica01;
import java.util.List;

/**
 *
 * @author Codigy
 * @param <T>
 */
public interface IDAO<T, ID> {

    public T buscarById(ID id);

    List<T> buscarAll();

    public boolean guardar(T p);

    public boolean eliminar(T p);

    public boolean modificar(T p);
}
