/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yahirsd.conejo.utils;

import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.image.TextureLoader;
import java.awt.Container;
import javax.media.j3d.Appearance;
import javax.media.j3d.Texture;

/**
 *
 * @author yahirsd
 */
final public class AppearanceTexture {

    /**
     * Suma binaria de GENERATE_NORMALS y GENERATE_TEXTURE_COORDS.
     * Especifica que las normales se generan junto con las posiciones y
     * Especifica que las coordenadas de textura se generan junto con las
     * posiciones.
     * <code>Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS</code>
     */
    public static int FLAGS = Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS;

    /**
     * devulbe una apariencia con textura de imagen.
     *
     * @param url url de la imagen.
     *
     * @return appearance es la apariencia ya lista para usar.
     */
    public static Appearance getAppearance(String url) {
        Appearance appearance = new Appearance();
        TextureLoader loader = new TextureLoader(url, "INTENSITY", new Container());
        Texture textura = loader.getTexture();
        appearance.setTexture(textura);
        return appearance;
    }
}
