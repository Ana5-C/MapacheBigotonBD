public class servicios {
   
    

    @OneToMany(mappedBy = "servicio")
    List<CitaServicios> CitaServicios;
}
