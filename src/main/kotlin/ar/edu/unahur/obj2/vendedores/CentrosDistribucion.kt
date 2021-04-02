package ar.edu.unahur.obj2.vendedores


abstract class CentroDeDistribucion {
    val estaEnLaCiudadDe: Ciudad = TODO()
    val trabajaCon = mutableListOf<Vendedor>()

    fun agregarTrabajador(unVendedor: Vendedor) {
        trabajaCon.add(unVendedor)
    }

    fun sacarTrabajador(unVendedor: Vendedor) {
        if (trabajaCon.contains(unVendedor)) trabajaCon.remove(unVendedor)
        else this.error("No era empleado")
    }

    abstract fun error(s: String)

    fun vendedorEstrella(): Vendedor? {
        return trabajaCon.maxBy { vendedor: Vendedor -> vendedor.puntajeCertificaciones() }
    }
    fun puedeCubrir(unaCiudad:Ciudad): Boolean {
        return trabajaCon.any { vendedor: Vendedor -> vendedor.puedeTrabajarEn(unaCiudad) }
    }
    fun vendedoresGenericos(){
        return trabajaCon.map({vendedor => vendedor.certificacionesComunes() >= 1})
    }


}

