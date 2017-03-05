package com.example.example.EnumExample;

/**
 * This enum is used extensively in the {@link EnumExample} class
 *
 * Check that out to see how it's used
 */
public enum ContactMethod {
    PHONE("telephone.png") {
        @Override
        public void initiate(String username) {
            System.out.println("Ring ringing: "  + username);
        }
    },
    EMAIL("email.png") {
        @Override
        public void initiate(String username) {
            System.out.println("Emailing: "  + username);
        }
    };

    ContactMethod(String icon) {
        this.icon = icon;
    }

    private String icon;

    public abstract void initiate(String username);

    public String getIcon() {
        return icon;
    }
}
