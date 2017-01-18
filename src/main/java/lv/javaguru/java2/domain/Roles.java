package lv.javaguru.java2.domain;

public enum Roles {
    ROLE_USER(1L)
    ,ROLE_ADMIN(2L);

    private Long idInDB;

    Roles(Long idInDB) {
        this.idInDB = idInDB;
    }

    public Long getIdInDB() {
        return idInDB;
    }

    public String toStringWithOutPrefixROLE() {
        return this.name().replaceAll("ROLE_","");
    }
}
