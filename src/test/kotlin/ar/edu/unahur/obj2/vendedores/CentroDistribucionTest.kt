package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue



class CentroDistribucion : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)
  val obera = Ciudad(misiones)
  val vendedorFijo = VendedorFijo(obera)
  val cordoba = Provincia(2000000)
  val villaDolores = Ciudad(cordoba)
  val viajante = Viajante(listOf(misiones))

  describe("centralita") {
    var central = CentroDeDistribucion()
    central.agregarTrabajador(vendedorFijo)
    central.agregarTrabajador(viajante)

    describe("Pruebas"){
      it("esRobusto"){
        central.esRobusto().shouldBeFalse()
      }
      it("puedeCubrir"){
        central.puedeCubrir(misiones).shouldBeTrue()
      }
      it("coleccionVendedores"){
        
      }


    }

  }

})


