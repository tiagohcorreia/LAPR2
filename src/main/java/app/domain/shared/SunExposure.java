package app.domain.shared;

import app.domain.model.Role;

public enum SunExposure {
    NORTH(1){
        @Override
        public String toString() {
            return String.format("North");
        }
    },
    EAST(2){
        @Override
        public String toString() {
            return String.format("East");
        }
    },
    SOUTH(3){
        @Override
        public String toString() {
            return String.format("South");
        }
    },
    WEST(4){
        @Override
        public String toString() {
            return String.format("West");
        }
    };

    private final int valor;

    SunExposure(int valor) {
        this.valor = valor;
    }

    public int getSunExposureID() {
        return this.valor;
    }

    public static SunExposure getSunExposureById(int id) {

        SunExposure[] array = SunExposure.values();

        for (int i = 0; i < array.length; i++) {

            if (id == array[i].getSunExposureID()) {

                return array[i];
            }
        }
        return null;
    }
}

