public class Servicio {
   
    

    @OneToMany(mappedBy = "servicio")
    List<CitaServicios> CitaServicios;
}
