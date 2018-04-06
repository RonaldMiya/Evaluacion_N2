package rmiya.com.evaluacion_n2.repositories;

/**
 * Created by Alumno on 5/04/2018.
 */

import java.util.ArrayList;
import java.util.List;

import rmiya.com.evaluacion_n2.models.Company;

public class CompanyRepository {

    private static List<Company> empresa = new ArrayList<>();

    static {

        empresa.add(new Company(100, "Gastronomia", "Tanta", "Centro Comercial Jockey Plaza, Av. Javier Prado Este 4200, Santiago de Surco 15023", 4377623, "empresa1@gmail.com", "https://www.google.com", "comp1", "Compañia dedicada a la gastronomia"));
        empresa.add(new Company(101, "Venta", "Metro", "Santa Anita 556", 123451, "empresa2@gmail.com", "https://www.metro.pe/", "comp2", "Compañia dedicada a la venta de productos"));
        empresa.add(new Company(102, "Medicina", "Inkafarma", "Santa Anita 557", 123452, "empresa3@gmail.com", "https://www.inkafarma.com.pe/", "comp3", "Compañia dedicada a la venta de Medicinas"));
        empresa.add(new Company(103, "Economia", "BBVA", "Santa Anita 558", 123453, "empresa4@gmail.com", "https://www.bbvacontinental.pe", "comp4", "Compañia dedicada a la economia"));
        empresa.add(new Company(104, "Entretenimiento", "UVK", "Santa Anita 559", 123454, "empresa5@gmail.com", "http://uvkmulticines.com/cartelera/", "comp5", "Compañia dedicada al entretenimiento"));
        empresa.add(new Company(105, "Educacion", "Empresa 6", "Santa Anita 560", 123455, "empresa1@gm6il.com", "url", "comp6", "Compañia dedicada a la Mineria"));
        empresa.add(new Company(106, "Entretenimiento", "Cinepolis", "Santa Anita 561", 123457, "empresa7@gmail.com", "https://www.cinepolis.com.pe/", "comp7", "Compañia dedicada al entretenimiento"));
        empresa.add(new Company(107, "Educacion", "U. San Marcos", "Santa Anita 562", 123458, "empresa8@gmail.com", "http://www.unmsm.edu.pe/", "comp8", "Compañia dedicada ala educacion"));
        empresa.add(new Company(108, "Venta", "Plaza Vea", "Santa Anita 563", 123459, "empresa9@gmail.com", "https://www.plazavea.com.pe/", "comp9", "Compañia dedicada a la venta de productos"));
    }

    public static List<Company> getList() {
        return empresa;
    }

}
