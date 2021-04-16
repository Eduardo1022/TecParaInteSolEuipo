//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.04.16 a las 02:58:59 AM CDT 
//


package me.equipo8.transporte;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lista" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="placa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="marca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="anio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="asientos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "lista"
})
@XmlRootElement(name = "ListaDeCarrosResponse")
public class ListaDeCarrosResponse {

    @XmlElement(required = true)
    protected List<ListaDeCarrosResponse.Lista> lista;

    /**
     * Gets the value of the lista property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lista property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLista().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaDeCarrosResponse.Lista }
     * 
     * 
     */
    public List<ListaDeCarrosResponse.Lista> getLista() {
        if (lista == null) {
            lista = new ArrayList<ListaDeCarrosResponse.Lista>();
        }
        return this.lista;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="placa" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="marca" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="anio" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="asientos" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id",
        "placa",
        "marca",
        "anio",
        "asientos"
    })
    public static class Lista {

        protected int id;
        @XmlElement(required = true)
        protected String placa;
        @XmlElement(required = true)
        protected String marca;
        protected int anio;
        protected int asientos;

        /**
         * Obtiene el valor de la propiedad id.
         * 
         */
        public int getId() {
            return id;
        }

        /**
         * Define el valor de la propiedad id.
         * 
         */
        public void setId(int value) {
            this.id = value;
        }

        /**
         * Obtiene el valor de la propiedad placa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlaca() {
            return placa;
        }

        /**
         * Define el valor de la propiedad placa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlaca(String value) {
            this.placa = value;
        }

        /**
         * Obtiene el valor de la propiedad marca.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMarca() {
            return marca;
        }

        /**
         * Define el valor de la propiedad marca.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMarca(String value) {
            this.marca = value;
        }

        /**
         * Obtiene el valor de la propiedad anio.
         * 
         */
        public int getAnio() {
            return anio;
        }

        /**
         * Define el valor de la propiedad anio.
         * 
         */
        public void setAnio(int value) {
            this.anio = value;
        }

        /**
         * Obtiene el valor de la propiedad asientos.
         * 
         */
        public int getAsientos() {
            return asientos;
        }

        /**
         * Define el valor de la propiedad asientos.
         * 
         */
        public void setAsientos(int value) {
            this.asientos = value;
        }

    }

}
