package by.it.yaskevich.jd01_09;

interface Patterns {
    String OPERATION = "[+*/-]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{(?<array>(-?[0-9]+(.[0-9]+)?)(,-?[0-9]+(\\.[0-9]+)?)*)\\}";
    String MATRIX = "\\{(?<arrays>\\{(-?[0-9]+(.[0-9]+)?)(,-?[0-9]+(\\.[0-9]+)?)*\\}(,\\{(-?[0-9]+(.[0-9]+)?)(,-?[0-9]+(\\.[0-9]+)?)*\\})*)\\}";
}
