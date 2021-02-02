
describe("My First Test", function () {
  it("Test api calls, events, tables, pagination, input,", function () {
    
    cy.visit("http://localhost:3000/");

    cy.request("http://localhost:8080/events/500").should((response) => {
      expect(response.status).to.eq(200);
      expect(response.body).to.have.length(500);
    });
    
    cy.get(".numberInput").should("have.value", "10");

    cy.get(".table")
      .find("tr")
      .should("have.length", "11")
      .find("td")
      .should("have.length", "30");

    cy.contains("1").click();
    cy.contains("2").click();
    cy.contains("3").click();
    cy.contains("4").click();
    cy.contains("5").click();
    cy.contains("6").click();
    cy.contains("7").click();
    cy.contains("8").click();
    cy.contains("9").click();
    cy.contains("10").click();

    cy.get(".table").find("tr").should("have.length", "11");

    cy.get(".numberInput").type("{backspace}{backspace}");
    cy.get(".table")
      .find("tr")
      .should("have.length", "1")
      .find("td")
      .should("have.length", "0");

    cy.get(".numberInput").type("50").should("have.value", "50");
    cy.get(".table").find("tr").should("have.length", "51");

    cy.get(".numberInput")
      .type("{backspace}{backspace}")
      .should("have.value", "")
      .type("3")
      .should("have.value", "3")
      .type("4")
      .should("have.value", "34");
    cy.get(".table").find("tr").should("have.length", "35");

    cy.contains("5").click();
    cy.get(".numberInput")
      .type("{backspace}{backspace}")
      .type("25")
      .should("have.value", "25");

    cy.get(".table")
      .find("tr")
      .should("have.length", "26")
      .find("td")
      .should("have.length", "75");

    cy.contains("10").click();
    cy.contains("1").click();
    cy.get(".table")
      .find("tr")
      .should("have.length", "26")
      .find("td")
      .should("have.length", "75");


      cy.get("a[aria-label=Next]").click();
      cy.get("a[aria-label=Previous]").click();
      cy.get("a[aria-label=Next]").click();
      cy.get(".numberInput")
      .type("{backspace}{backspace}")
      .type("5")
      .should("have.value", "5");

      cy.get(".table")
      .find("tr")
      .should("have.length", "6")
      .find("td")
      .should("have.length", "15");

      
      cy.get(".numberInput")
      .type("{backspace}{backspace}")
      .type("1")
      .should("have.value", "1");

      cy.contains("9").click();
      cy.contains("4");
      cy.contains("13");

      cy.contains("13").click();
      cy.contains("8");
      cy.contains("17");

      cy.contains("15").click();
      cy.contains("10");
      cy.contains("19");

      cy.contains("16").click();
      cy.contains("11");
      cy.contains("20");

      cy.contains("17").click();
      cy.contains("20").click();
      cy.contains("24").click();
      cy.contains("28").click();
      cy.contains("23");
      cy.contains("32");

      cy.get(".table")
      .find("tr")
      .should("have.length", "2")
      .find("td")
      .should("have.length", "3");

      cy.contains("27").click();
      cy.contains("26").click();
      cy.contains("24").click();
      cy.contains("21").click();
      cy.contains("16");
      cy.contains("25");

      cy.contains("17").click();
      cy.contains("13").click();
      cy.contains("8");
      cy.contains("17");

      cy.get(".table")
      .find("tr")
      .should("have.length", "2")
      .find("td")
      .should("have.length", "3");

      cy.get("a[aria-label=Previous]").click();
      cy.get("a[aria-label=Next]").click();
      

      cy.get(".numberInput")
      .type("0")
      .should("have.value", "10");

      cy.get(".table")
      .find("tr")
      .should("have.length", "11")
      .find("td")
      .should("have.length", "30");

  });
}); 
