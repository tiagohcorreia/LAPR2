package pt.ipp.isep.dei.esoft.project.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The enum Agency.
 */
public enum Agency {

    /**
     * The Agency 1.
     */
    AGENCY1(1) {
        @Override
        public String toString() {
            return String.format("AGENCY1");
        }

    },
    /**
     * The Agency 2.
     */
    AGENCY2(2) {
        @Override
        public String toString() {
            return String.format("AGENCY2");
        }

    },
    /**
     * The Agency 3.
     */
    AGENCY3(3) {
        @Override
        public String toString() {
            return String.format("AGENCY3");
        }
    };

    private final int valor;

    Agency(int valor) {
        this.valor = valor;
    }

    /**
     * Gets agency id.
     *
     * @return the agency id
     */
    public int getAgencyID() {
        return this.valor;
    }

    /**
     * Gets agency by id.
     *
     * @param id the id
     * @return the agency by id
     */
    public static Agency getAgencyById(int id) {

        Agency[] array = Agency.values();

        for (int i = 0; i < array.length; i++) {

            if (id == array[i].getAgencyID()) {

                return array[i];
            }
        }
        return null;
    }

}
