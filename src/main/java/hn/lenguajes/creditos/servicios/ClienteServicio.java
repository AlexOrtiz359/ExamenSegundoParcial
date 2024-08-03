package hn.lenguajes.creditos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hn.lenguajes.creditos.modelos.Cliente;
import hn.lenguajes.creditos.modelos.Prestamo;
import hn.lenguajes.creditos.repositorios.ClienteRepositorio;
import hn.lenguajes.creditos.repositorios.PrestamoRepositorio;

public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;


    @Autowired
    private PrestamoRepositorio prestamoRepositorio;


    public Cliente crearCliente(Cliente nvoCliente){

        if(!this.clienteRepositorio.existsById(nvoCliente.getDni())){

            List<Prestamo> nvPrestamo = nvoCliente.getPrestamos();
            if(nvPrestamo!=null){
                
            for(Prestamo prestamo : nvPrestamo){
                Double cuota = calcularCuotas(prestamo);
                prestamo.setCuota(cuota);;
                prestamo.setCliente(nvoCliente);
                this.prestamoRepositorio.save(prestamo);
                }
            }
            return this.clienteRepositorio.save(nvoCliente);
        } else{
            return null;
        }
    }

    private Double calcularCuotas(Prestamo prestamo) {
        Double monto = prestamo.getMonto();
        Long plazo = prestamo.getPlazo();
        Double tasaInteres = 0.09/12;

        Double cuotaMensual = (monto * tasaInteres * (Math.pow(1 + tasaInteres, plazo*12)) / (Math.pow(1 + tasaInteres, plazo*12)-1));

        return cuotaMensual;
    }

    public List<Cliente> obtenerTodos(){
        return this.clienteRepositorio.findAll();
    }


    /*private void generarCuotas(Prestamo prestamo) {
        Double monto = prestamo.getMonto();
        Double cuota = prestamo.getCuota();
        Long plazo = prestamo.getPlazo();
        Double tasaInteres = 0.09 / 12;

        Double saldo = monto;

        for (int mes = 0; mes <= plazo * 12; mes++) {
            Cuota cuota = new Cuota();
            cuota.setPrestamo(prestamo);
            cuota.setMes(mes);

            if (mes == 0) {
                cuota.setInteres(0.0);
                cuota.setCapital(0.0);
                cuota.setSaldo(saldo);
            } else {
                Double interes = saldo * tasaInteres;
                Double capital = cuota - interes;
                saldo = saldo - capital;

                cuota.setInteres(interes);
                cuota.setCapital(capital);
                cuota.setSaldo(saldo);
            }

            this.cuotaRepositorio.save(cuota);
        }
    }
    */

}
