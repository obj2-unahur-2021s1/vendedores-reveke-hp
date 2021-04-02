package ar.edu.unahur.obj2.vendedores

import ar.edu.unahur.obj2.vendedores.Ciudad as Ciudad1



class Certificacion(val esDeProducto: Boolean, val puntaje: Int)

abstract class Vendedor {
  val certificaciones = mutableListOf<Certificacion>()
  abstract fun puedeTrabajarEn(ciudad: Ciudad1): Boolean
  fun esVersatil() =
    certificaciones.size >= 3
      && this.certificacionesDeProducto() >= 1
      && this.otrasCertificaciones() >= 1
  fun agregarCertificacion(certificacion: Certificacion) {
    certificaciones.add(certificacion)
  }
  fun esFirme() = this.puntajeCertificaciones() >= 30
  fun certificacionesDeProducto() = certificaciones.count { it.esDeProducto }
  fun otrasCertificaciones() = certificaciones.count { !it.esDeProducto }
  fun puntajeCertificaciones() = certificaciones.sumBy { c -> c.puntaje }
}

class VendedorFijo(private val ciudadOrigen: Ciudad1) : Vendedor() {
  override fun puedeTrabajarEn(ciudad: Ciudad1): Boolean {
    return ciudad == ciudadOrigen
  }
  fun esInfluyente(): Boolean {
    return false
  }
}

class Viajante(private val provinciasHabilitadas: List<Provincia>) : Vendedor() {
  override fun puedeTrabajarEn(ciudad: Ciudad1): Boolean {
    return provinciasHabilitadas.contains(ciudad.provincia)
  }
  fun esInfluyente(): Boolean {
    return (provinciasHabilitadas.sumBy { provincia ->  provincia.poblacion } >= 10000000)
  }
}


class ComercioCorresponsal(private var ciudades: List<Provincia>) : Vendedor() {
  val tieneSucursalEn = mutableListOf<Ciudad1>()
  override fun puedeTrabajarEn(ciudad: Ciudad1): Boolean {
    return tieneSucursalEn.contains(ciudad)
  }
  fun agregarSucursal(unaCiudad: Ciudad1){
    tieneSucursalEn.add(unaCiudad)
  }
  fun sacarSucursal(unaCiudad: Ciudad1){
    tieneSucursalEn.remove(unaCiudad)
  }
  fun esInfluyente(): Boolean {
    return (cantidadDeSucursales() >= 5) or (cantidadDeProvincias() >= 3)
  }
  private fun cantidadDeProvincias(): Int {
    val provincias = mutableListOf<Ciudad1>()
    return provincias.size
  }
  private fun cantidadDeSucursales(): Int {
    return tieneSucursalEn.size
  }
}
