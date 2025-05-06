
public class IfThenOperator extends Operator {
    public IfThenOperator() {
    	sOperator = "=>";
        newlevel = 1;
    }

    @Override
    public boolean booleanResult(boolean l, boolean r) {
        return !l || r;
    }
}
