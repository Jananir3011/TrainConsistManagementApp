package org.example;

public class GoodsBogie {

    private String type;
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public void assignCargo(String cargo) {
        try {
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe cargo assignment: Petroleum not allowed in Rectangular bogie"
                );
            }

            this.cargo = cargo;

        } catch (CargoSafetyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Assignment completed");
        }
    }
}