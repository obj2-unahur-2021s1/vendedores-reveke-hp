package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue


class CentroDistribucion : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)

  describe("centralita") {
    val obera = Ciudad(misiones)
    val central = CentroDeDistribucion()

    describe("vendedor Estrella") {
      it("su ciudad de origen") {
        central.vendedorEstrella().shouldBeTrue()
        central.vendedorEstrella().assertEquals(obrera)
      }

  }

})


