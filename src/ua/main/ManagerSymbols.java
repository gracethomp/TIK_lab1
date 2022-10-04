package ua.main;

import java.util.HashMap;
import java.util.Map;


public record ManagerSymbols(String stringToCount) {
    private static final Integer BASE_OF_THE_LOGARITHM = 2;

    private HashMap<Character, Double> getEachSymbol() {
        HashMap<Character, Double> symbols = new HashMap<>();
        char[] chars = stringToCount.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (symbols.containsKey(chars[i])) {
                continue;
            }
            final int j = i;
            symbols.put(chars[j], (double) (stringToCount.chars()
                    .filter(e -> e == chars[j]).count())/stringToCount.length());
        }
        return symbols;
    }

    private HashMap<Character, Double> getEntropyByLetter() {
        HashMap<Character, Double> symbols = new HashMap<>();
        for (Map.Entry<Character, Double> e : getEachSymbol().entrySet()) {
            symbols.put(e.getKey(), - (Math.log(e.getValue())/Math.log(2))*e.getValue());
        }
        return symbols;
    }

    public double getEntropy() {
        return getEntropyByLetter().values().stream()
                .mapToDouble(Double::doubleValue).sum();
    }

    public Double getAverageEntropy() {
        return getEntropy()/getEntropyByLetter().size();
    }

    public Double getAmountInformation() {
        return getEntropy() * stringToCount.length();
    }

    public Double getMaxEntropy() {
        return (Math.log(getEntropyByLetter().size())/Math.log(BASE_OF_THE_LOGARITHM));
    }

    public Double getAbsoluteExcess() {
        return getMaxEntropy() - getEntropy();
    }

    public Double getRelativeExcess() {
        return getAbsoluteExcess()/getMaxEntropy();
    }
}
