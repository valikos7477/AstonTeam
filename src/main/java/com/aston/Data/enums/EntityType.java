package com.aston.Data.enums;

public enum EntityType {
        HUMAN(1),
        ANIMAL(2),
        BOX(3),
        MIXED(4);
        private final int value;

        EntityType(int value) {
            this.value = value;
        }

        public static EntityType fromValue(int value) {
            for (EntityType type : EntityType.values()) {
                if (type.value == value) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid entity type value: " + value);
        }
    }
