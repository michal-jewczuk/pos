package net.jewczuk.posdomain.entity;

public enum Animals {
    CAT {
        @Override
        String makeASound() {
            return "Miau!";
        }
    },
    DOG {
        @Override
        String makeASound() {
            return "Hau hau!";
        }
    },
    FISH {
        @Override
        String makeASound() {
            return "???????????????";
        }
    };

    abstract String makeASound();
}
