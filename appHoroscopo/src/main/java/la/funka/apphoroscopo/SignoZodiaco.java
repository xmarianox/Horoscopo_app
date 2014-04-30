package la.funka.apphoroscopo;

public class SignoZodiaco extends Signo {

    // Construcctor del Objeto Signo.
    public SignoZodiaco(String nombreSigno) {
        super(nombreSigno);
    }

    // Construcctor del Objeto Signo.
    public SignoZodiaco(){

    };

    public String dameSigno(int dia, int mes) {
        String signo;
        signo = "";

        if( (dia >= 21 && mes == 1) || (dia <= 19 && mes == 2) ) {
            signo = "Acuario";
        } else {
            if( (dia >= 20 && mes == 2) || (dia <= 20 && mes == 3) ) {
                signo = "Piscis";
            } else {
                if( (dia >= 21 && mes == 3) || (dia <= 20 && mes == 4) ) {
                    signo = "Aries";
                } else {
                    if( (dia >= 21 && mes == 4) || (dia <= 21 && mes == 5) ) {
                        signo = "Tauro";
                    } else {
                        if( (dia >= 22 && mes == 5) || (dia <= 21 && mes == 6) ) {
                            signo = "Géminis";
                        } else {
                            if( (dia >= 21 && mes == 6) || (dia <= 23 && mes == 7) ) {
                                signo = "Cáncer";
                            } else {
                                if( (dia >= 24 && mes == 7) || (dia <= 23 && mes == 8) ) {
                                    signo = "Leo";
                                } else {
                                    if( (dia >=24 && mes == 8) || (dia <=23 && mes == 9) ) {
                                        signo = "Virgo";
                                    } else {
                                        if( (dia >=24 && mes == 9) || (dia <= 23 && mes == 10) ) {
                                            signo = "Libra";
                                        } else {
                                            if( (dia >=24 && mes == 10) || (dia <= 22 && mes == 11) ) {
                                                signo = "Escorpio";
                                            } else {
                                                if( (dia >= 23 && mes == 11) || (dia <= 21 && mes == 12) ) {
                                                    signo = "Sagitario";
                                                } else {
                                                    if( (dia >= 22 && mes == 12) || (dia <= 20 && mes == 1) )
                                                        signo = "Capricornio";
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return signo;
    }

    @Override
    public int setUrlIcon(String nombreSigno) {
        int idSigno;

        if (nombreSigno.equals("Acuario")) {
            idSigno = R.drawable.acuario;
        } else {
            if (nombreSigno.equals("Piscis")){
                idSigno = R.drawable.piscis;
            } else {
                if (nombreSigno.equals("Aries")){
                    idSigno = R.drawable.aries;
                } else {
                    if (nombreSigno.equals("Tauro")){
                        idSigno = R.drawable.tauro;
                    } else {
                        if (nombreSigno.equals("Géminis")){
                            idSigno = R.drawable.geminis;
                        } else {
                            if (nombreSigno.equals("Cáncer")){
                                idSigno = R.drawable.cancer;
                            } else {
                                if (nombreSigno.equals("Leo")){
                                    idSigno = R.drawable.leo;
                                } else {
                                    if (nombreSigno.equals("Virgo")){
                                        idSigno = R.drawable.virgo;
                                    } else {
                                        if (nombreSigno.equals("Libra")){
                                            idSigno = R.drawable.libra;
                                        } else {
                                            if (nombreSigno.equals("Escorpio")){
                                                idSigno = R.drawable.escorpio;
                                            } else {
                                                if (nombreSigno.equals("Sagitario")){
                                                    idSigno = R.drawable.sagitario;
                                                } else {
                                                    idSigno = R.drawable.capricornio;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return idSigno;
    }

    @Override
    public int prediccionAmor(String nombreSigno) {
        int idSigno;

        if (nombreSigno.equals("Acuario")) {
            idSigno = R.string.acuario_amor;
        } else {
            if (nombreSigno.equals("Piscis")){
                idSigno = R.string.piscis_amor;
            } else {
                if (nombreSigno.equals("Aries")){
                    idSigno = R.string.aries_amor;
                } else {
                    if (nombreSigno.equals("Tauro")){
                        idSigno = R.string.tauro_amor;
                    } else {
                        if (nombreSigno.equals("Géminis")){
                            idSigno = R.string.geminis_amor;
                        } else {
                            if (nombreSigno.equals("Cáncer")){
                                idSigno = R.string.cancer_amor;
                            } else {
                                if (nombreSigno.equals("Leo")){
                                    idSigno = R.string.leo_amor;
                                } else {
                                    if (nombreSigno.equals("Virgo")){
                                        idSigno = R.string.virgo_amor;
                                    } else {
                                        if (nombreSigno.equals("Libra")){
                                            idSigno = R.string.libra_amor;
                                        } else {
                                            if (nombreSigno.equals("Escorpio")){
                                                idSigno = R.string.escorpio_amor;
                                            } else {
                                                if (nombreSigno.equals("Sagitario")){
                                                    idSigno = R.string.sagitario_amor;
                                                } else {
                                                    idSigno = R.string.capricornio_amor;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return idSigno;
    }

    @Override
    public int prediccionSalud(String nombreSigno) {
        int idSigno;

        if (nombreSigno.equals("Acuario")) {
            idSigno = R.string.acuario_salud;
        } else {
            if (nombreSigno.equals("Piscis")){
                idSigno = R.string.piscis_salud;
            } else {
                if (nombreSigno.equals("Aries")){
                    idSigno = R.string.aries_salud;
                } else {
                    if (nombreSigno.equals("Tauro")){
                        idSigno = R.string.tauro_salud;
                    } else {
                        if (nombreSigno.equals("Géminis")){
                            idSigno = R.string.geminis_salud;
                        } else {
                            if (nombreSigno.equals("Cáncer")){
                                idSigno = R.string.cancer_salud;
                            } else {
                                if (nombreSigno.equals("Leo")){
                                    idSigno = R.string.leo_salud;
                                } else {
                                    if (nombreSigno.equals("Virgo")){
                                        idSigno = R.string.virgo_salud;
                                    } else {
                                        if (nombreSigno.equals("Libra")){
                                            idSigno = R.string.libra_salud;
                                        } else {
                                            if (nombreSigno.equals("Escorpio")){
                                                idSigno = R.string.escorpio_salud;
                                            } else {
                                                if (nombreSigno.equals("Sagitario")){
                                                    idSigno = R.string.sagitario_salud;
                                                } else {
                                                    idSigno = R.string.capricornio_salud;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return idSigno;
    }

    @Override
    public int prediccionDinero(String nombreSigno) {
        int idSigno;

        if (nombreSigno.equals("Acuario")) {
            idSigno = R.string.acuario_dinero;
        } else {
            if (nombreSigno.equals("Piscis")){
                idSigno = R.string.piscis_dinero;
            } else {
                if (nombreSigno.equals("Aries")){
                    idSigno = R.string.aries_dinero;
                } else {
                    if (nombreSigno.equals("Tauro")){
                        idSigno = R.string.tauro_dinero;
                    } else {
                        if (nombreSigno.equals("Géminis")){
                            idSigno = R.string.geminis_dinero;
                        } else {
                            if (nombreSigno.equals("Cáncer")){
                                idSigno = R.string.cancer_dinero;
                            } else {
                                if (nombreSigno.equals("Leo")){
                                    idSigno = R.string.leo_dinero;
                                } else {
                                    if (nombreSigno.equals("Virgo")){
                                        idSigno = R.string.virgo_dinero;
                                    } else {
                                        if (nombreSigno.equals("Libra")){
                                            idSigno = R.string.libra_dinero;
                                        } else {
                                            if (nombreSigno.equals("Escorpio")){
                                                idSigno = R.string.escorpio_dinero;
                                            } else {
                                                if (nombreSigno.equals("Sagitario")){
                                                    idSigno = R.string.sagitario_dinero;
                                                } else {
                                                    idSigno = R.string.capricornio_dinero;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return idSigno;
    }

}
