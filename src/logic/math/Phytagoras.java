package logic.math;

public class Phytagoras {

    private Double hypotenuse, perpendicular, base;

    public Phytagoras(Double hypotenuse, Double perpendicular, Double base) {
        this.setHypotenuse(hypotenuse);
        this.setHypotenuse(perpendicular);
        this.base = base;
    }
    public Phytagoras(Double hypotenuse, Double perpendicular) {
        this.setHypotenuse(hypotenuse);
        this.setHypotenuse(perpendicular);
    }
    public Phytagoras(Double hypotenuse) {
        this.setHypotenuse(hypotenuse);
    }
    public Phytagoras() {
    }

    // Getter
    public Double getHypotenuse() {
        return hypotenuse;
    }
    public Double getPerpendicular() {
        return perpendicular;
    }
    public Double getBase() {
        return base;
    }

    // setter
    public void setHypotenuse(Double hypotenuse) {
        this.hypotenuse = hypotenuse;
    }
    public void setPerpendicular(Double perpendicular) {
        this.perpendicular = perpendicular;
    }
    public void setBase(Double base) {
        this.base = base;
    }

    // calculate
    public Double calculateHypotenuse() throws Exception {
        try {
            return Math.sqrt(
                    Math.pow( this.getPerpendicular(), 2 ) + Math.pow( this.getBase(), 2 )
                );
        } catch (Exception ex) {  
            throw new Exception(ex.getMessage());
        }
    }
    public Double calculatePerpendicular() throws Exception {
        try {
            return Math.sqrt(
                    Math.pow( this.getHypotenuse(), 2 ) - Math.pow( this.getBase(), 2 )
                );
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    public Double calculateBase() throws Exception {
        try {
            return Math.sqrt(
                    Math.pow( this.getHypotenuse(), 2 ) - Math.pow( this.getPerpendicular(), 2 )
                );
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
