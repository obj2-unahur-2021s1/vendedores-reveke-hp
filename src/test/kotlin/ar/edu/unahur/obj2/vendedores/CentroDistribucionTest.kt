package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class CentroDePruebas: DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)
  val obera = Ciudad(misiones)
  val vendedorFijo = VendedorFijo(obera)
  val cordoba = Provincia(2000000)
  val villaDolores = Ciudad(cordoba)
  val viajante = Viajante(listOf(misiones))
  val central = CentroDeDistribution(sanIgnacio)
  central.agregarTrabajador(viajante)
  central.agregarTrabajador(vendedorFijo)

  describe("Pruebas"){
    it("esRobusto"){
      central.esRobusto().shouldBeFalse()
    }
    it("puedeCubrir"){
      central.puedeCubrir(sanIgnacio).shouldBeTrue()
    }
    it("coleccionVendedores"){
      central.vendedoresGenericos().shouldNotBe(viajante)
    }
    it("vendedorEstrella"){
      central.vendedorEstrella().shouldNotBe(vendedorFijo)
    }
  }

})



