package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class VendedorTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)

  describe("Vendedor fijo") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)

    describe("puedeTrabajarEn") {
      it("su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
      it("es influyente"){
        vendedorFijo.esInfluyente().shouldBeFalse()
      }
    }
  }

  describe("Viajante") {
    val cordoba = Provincia(2000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(misiones))

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeFalse()
      }
      it("es influyente"){
        viajante.esInfluyente().shouldBeFalse()
      }
    }
  }
  describe("comercioCorresponsal") {
    val buenosAires = Provincia(100000)
    val hurlingham = Ciudad(buenosAires)
    val comercio = ComercioCorresponsal(listOf(buenosAires))
    comercio.agregarSucursal(hurlingham)

    describe("puedeTrabajarEn") {
      it("puede trabajar en una ciudad") {
        comercio.puedeTrabajarEn(hurlingham).shouldBeTrue()
      }
      it("es vertasil") {
        comercio.esVersatil().shouldBeFalse()
      }
      it("es firme") {
        comercio.esFirme().shouldBeFalse()
      }
      it("es influyente"){
        comercio.esInfluyente().shouldBeFalse()
      }
    }
  }
})


