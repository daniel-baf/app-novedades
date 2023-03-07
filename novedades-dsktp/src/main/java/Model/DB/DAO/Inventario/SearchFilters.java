/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Model.DB.DAO.Inventario;

/**
 * @author mayoneso
 */
public enum SearchFilters {
    BY_SIZE("Talla"),
    BY_COLOR("Color"),
    BY_NAME("Nombre Pieza"),
    BY_INV_ID("ID inventario"),
    NONE("NINGUNO");

    private final String value;

    SearchFilters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
