public enum Region {
    BATKEN {
        @Override
        public String getUniqueInfo() {
            return "Aigul gulu";
        }
    },
    OSH {
        @Override
        public String getUniqueInfo() {
            return "Sulaiman Too";
        }
    },
    JALAL_ABAD {
        @Override
        public String getUniqueInfo() {
            return "Arslanbab";
        }
    },
    TALAS {
        @Override
        public String getUniqueInfo() {
            return "Manas baatyr";
        }
    },
    CHUI {
        @Override
        public String getUniqueInfo() {
            return "Bishkek";
        }
    },
    YSSYK_KOL {
        @Override
        public String getUniqueInfo() {
            return "Kyrgyzstandy bermeti";
        }
    },
    NARYN {
        @Override
        public String getUniqueInfo() {
            return "Son kol jailoosu";
        }
    };

    public abstract String getUniqueInfo();
}
