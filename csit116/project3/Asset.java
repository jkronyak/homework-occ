
/**
 * Project 3 - Net Worth
 *
 * @author Gerald Cohen, Ph.D. Copyright (c) 2019
 */
public interface Asset {

    double getValue();

    default double getNetValue() {
        return getValue();
    }

    String getName();
}
