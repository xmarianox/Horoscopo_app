package la.funka.apphoroscopo;

public class SignoChino extends Signo {

    // Construcctor del Objeto Signo.
    public SignoChino(String nombreSigno) {
        super(nombreSigno);
    }

    // Construcctor del Objeto Signo.
    public SignoChino(){

    };

    public String dameSigno(int anio) {
        String[] signos = {"Mono", "Gallo", "Perro", "Cerdo", "Rata", "Buey", "Tigre", "Conejo", "Dragon", "Serpiente", "Caballo", "Cabra"};

        String signo_user = "";

        switch (anio%12) {
            case 0 : // Mono
                signo_user = signos[0];
                break;
            case 1 : // Gallo
                signo_user = signos[1];
                break;
            case 2 : // Perro
                signo_user = signos[2];
                break;
            case 3 : // Cerdo
                signo_user = signos[3];
                break;
            case 4 : // Rata
                signo_user = signos[4];
                break;
            case 5 : // Buey
                signo_user = signos[5];
                break;
            case 6 : // Tigre
                signo_user = signos[6];
                break;
            case 7 : // Conejo
                signo_user = signos[7];
                break;
            case 8 : // Dragon
                signo_user = signos[8];
                break;
            case 9 : // Serpiente
                signo_user = signos[9];
                break;
            case 10 : // Caballo
                signo_user = signos[10];
                break;
            case 11 : // Cabra
                signo_user = signos[11];
                break;
        }
        return signo_user;
    }

    @Override
    public int setUrlIcon(String nombreSigno) {
        int idSigno;

        if (nombreSigno.equals("Mono")) {
            idSigno = R.drawable.mono;
        } else {
            if (nombreSigno.equals("Gallo")){
                idSigno = R.drawable.gallo;
            } else {
                if (nombreSigno.equals("Perro")){
                    idSigno = R.drawable.perro;
                } else {
                    if (nombreSigno.equals("Cerdo")){
                        idSigno = R.drawable.cerdo;
                    } else {
                        if (nombreSigno.equals("Rata")){
                            idSigno = R.drawable.rata;
                        } else {
                            if (nombreSigno.equals("Buey")){
                                idSigno = R.drawable.buey;
                            } else {
                                if (nombreSigno.equals("Tigre")){
                                    idSigno = R.drawable.tigre;
                                } else {
                                    if (nombreSigno.equals("Conejo")){
                                        idSigno = R.drawable.conejo;
                                    } else {
                                        if (nombreSigno.equals("Dragon")){
                                            idSigno = R.drawable.dragon;
                                        } else {
                                            if (nombreSigno.equals("Serpiente")){
                                                idSigno = R.drawable.serpiente;
                                            } else {
                                                if (nombreSigno.equals("Caballo")){
                                                    idSigno = R.drawable.caballo;
                                                } else {
                                                    idSigno = R.drawable.cabra;
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

        if (nombreSigno.equals("Mono")) {
            idSigno = R.string.text_prediccion_amor_mono;
        } else {
            if (nombreSigno.equals("Gallo")){
                idSigno = R.string.text_prediccion_amor_gallo;
            } else {
                if (nombreSigno.equals("Perro")){
                    idSigno = R.string.text_prediccion_amor_perro;
                } else {
                    if (nombreSigno.equals("Cerdo")){
                        idSigno = R.string.text_prediccion_amor_cerdo;
                    } else {
                        if (nombreSigno.equals("Rata")){
                            idSigno = R.string.text_prediccion_amor_rata;
                        } else {
                            if (nombreSigno.equals("Buey")){
                                idSigno = R.string.text_prediccion_amor_buey;
                            } else {
                                if (nombreSigno.equals("Tigre")){
                                    idSigno = R.string.text_prediccion_amor_tigre;
                                } else {
                                    if (nombreSigno.equals("Conejo")){
                                        idSigno = R.string.text_prediccion_amor_conejo;
                                    } else {
                                        if (nombreSigno.equals("Dragon")){
                                            idSigno = R.string.text_prediccion_amor_dragon;
                                        } else {
                                            if (nombreSigno.equals("Serpiente")){
                                                idSigno = R.string.text_prediccion_amor_serpiente;
                                            } else {
                                                if (nombreSigno.equals("Caballo")){
                                                    idSigno = R.string.text_prediccion_amor_caballo;
                                                } else {
                                                    idSigno = R.string.text_prediccion_amor_cabra;
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

        if (nombreSigno.equals("Mono")) {
            idSigno = R.string.text_prediccion_salud_mono;
        } else {
            if (nombreSigno.equals("Gallo")){
                idSigno = R.string.text_prediccion_salud_gallo;
            } else {
                if (nombreSigno.equals("Perro")){
                    idSigno = R.string.text_prediccion_salud_perro;
                } else {
                    if (nombreSigno.equals("Cerdo")){
                        idSigno = R.string.text_prediccion_salud_cerdo;
                    } else {
                        if (nombreSigno.equals("Rata")){
                            idSigno = R.string.text_prediccion_salud_rata;
                        } else {
                            if (nombreSigno.equals("Buey")){
                                idSigno = R.string.text_prediccion_salud_buey;
                            } else {
                                if (nombreSigno.equals("Tigre")){
                                    idSigno = R.string.text_prediccion_salud_tigre;
                                } else {
                                    if (nombreSigno.equals("Conejo")){
                                        idSigno = R.string.text_prediccion_salud_conejo;
                                    } else {
                                        if (nombreSigno.equals("Dragon")){
                                            idSigno = R.string.text_prediccion_salud_dragon;
                                        } else {
                                            if (nombreSigno.equals("Serpiente")){
                                                idSigno = R.string.text_prediccion_salud_serpiente;
                                            } else {
                                                if (nombreSigno.equals("Caballo")){
                                                    idSigno = R.string.text_prediccion_salud_caballo;
                                                } else {
                                                    idSigno = R.string.text_prediccion_salud_cabra;
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

        if (nombreSigno.equals("Mono")) {
            idSigno = R.string.text_prediccion_dinero_mono;
        } else {
            if (nombreSigno.equals("Gallo")){
                idSigno = R.string.text_prediccion_dinero_gallo;
            } else {
                if (nombreSigno.equals("Perro")){
                    idSigno = R.string.text_prediccion_dinero_perro;
                } else {
                    if (nombreSigno.equals("Cerdo")){
                        idSigno = R.string.text_prediccion_dinero_cerdo;
                    } else {
                        if (nombreSigno.equals("Rata")){
                            idSigno = R.string.text_prediccion_dinero_rata;
                        } else {
                            if (nombreSigno.equals("Buey")){
                                idSigno = R.string.text_prediccion_dinero_buey;
                            } else {
                                if (nombreSigno.equals("Tigre")){
                                    idSigno = R.string.text_prediccion_dinero_tigre;
                                } else {
                                    if (nombreSigno.equals("Conejo")){
                                        idSigno = R.string.text_prediccion_dinero_conejo;
                                    } else {
                                        if (nombreSigno.equals("Dragon")){
                                            idSigno = R.string.text_prediccion_dinero_dragon;
                                        } else {
                                            if (nombreSigno.equals("Serpiente")){
                                                idSigno = R.string.text_prediccion_dinero_serpiente;
                                            } else {
                                                if (nombreSigno.equals("Caballo")){
                                                    idSigno = R.string.text_prediccion_dinero_caballo;
                                                } else {
                                                    idSigno = R.string.text_prediccion_dinero_cabra;
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
