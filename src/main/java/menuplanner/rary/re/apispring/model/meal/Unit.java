package menuplanner.rary.re.apispring.model.meal;

public enum Unit {
    KG("kg"), APIECE("pcs"), CUP("cup"), TBSP("tbsp"), TSP("tsp"), L("l"), ML("ml");

    public final String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
