/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yahirsd.conejo.utils;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

/**
 *
 * @author yahirsd
 */
public class Transform3DBuilder {

    /**
     * Transform3D global.
     */
    final private Transform3D transform3D = new Transform3D();

    /**
     * Agrega la translacion en el eje X en metros al transform3D global.
     *
     * Ejecuta el metodo mul del objeto Transform3D global pasando como
     * parametro un Transform3D temporal.
     *
     * <code>
     *  Transform3D tmp = new Transform3D();
     *  tmp.setTranslation(new Vector3d(x, 0, 0));
     *  transform3D.mul(tmp);
     *  return this;
     * </code>
     *
     * @param x metros translacion en el eje x en metros. Accepta valores
     * engativos.
     *
     * @return <code>this</code> instancia del mismo objeto Transform3DBuilder.
     */
    public Transform3DBuilder movX(double x) {
        Transform3D tmp = new Transform3D();
        tmp.setTranslation(new Vector3d(x, 0, 0));
        transform3D.mul(tmp);
        return this;
    }

    /**
     * Agrega la translacion en el eje Y en metros al transform3D global.
     *
     * Ejecuta el metodo mul del objeto Transform3D global pasando como
     * parametro un Transform3D temporal.
     *
     * <code>
     *  Transform3D tmp = new Transform3D();
     *  tmp.setTranslation(new Vector3d(0, y, 0));
     *  transform3D.mul(tmp);
     * </code>
     *
     * @param y metros translacion en el eje y en metros. Accepta valores
     * engativos.
     *
     * @return <code>this</code> instancia del mismo objeto Transform3DBuilder.
     */
    public Transform3DBuilder movY(double y) {
        Transform3D tmp = new Transform3D();
        tmp.setTranslation(new Vector3d(0, y, 0));
        transform3D.mul(tmp);
        return this;
    }

    /**
     * Agrega la translacion en el eje Z en metros al transform3D global.
     *
     * Ejecuta el metodo mul del objeto Transform3D global pasando como
     * parametro un Transform3D temporal.
     *
     * <code>
     *  Transform3D tmp = new Transform3D();
     *  tmp.setTranslation(new Vector3d(0, 0, z));
     *  transform3D.mul(tmp);
     * </code>
     *
     * @param z metros translacion en el eje z en metros. Accepta valores
     * engativos.
     *
     * @return <code>this</code> instancia del mismo objeto Transform3DBuilder.
     */
    public Transform3DBuilder movZ(double z) {
        Transform3D tmp = new Transform3D();
        tmp.setTranslation(new Vector3d(0, 0, z));
        transform3D.mul(tmp);
        return this;
    }

    /**
     * Agrega la rotacion en el eje X los grados que se indiquen al transform3D.
     * La rotacion se pasa en grados, rotX de Trasnform3D requiere los grados en
     * radianes asi que internamente se hace una conversion.
     *
     * Ejecuta el metodo mul del objeto Transform3D global pasando como
     * parametro un Transform3D temporal.
     *
     * <code>
     *  final Transform3D tmp = new Transform3D();
     *  tmp.rotX(Math.toRadians(x));
     *  transform3D.mul(tmp);
     * </code>
     *
     * @param x grados para rotar en el eje x.
     * @return una instancia del mismo objeto Transform3DBuilder
     * <code>this</code>
     */
    public Transform3DBuilder rotX(double x) {
        final Transform3D tmp = new Transform3D();
        tmp.rotX(Math.toRadians(x));
        transform3D.mul(tmp);
        return this;
    }

    /**
     * Agrega la rotacion en el eje Y los grados que se indiquen al transform3D.
     * La rotacion se pasa en grados, rotY de Trasnform3D requiere los grados en
     * radianes asi que internamente se hace una conversion.
     *
     * Ejecuta el metodo mul del objeto Transform3D global pasando como
     * parametro un Transform3D temporal.
     *
     * <code>
     *  final Transform3D tmp = new Transform3D();
     *  tmp.rotY(Math.toRadians(y));
     *  transform3D.mul(tmp);
     * </code>
     *
     * @param y grados para rotar en el eje y.
     * @return una instancia del mismo objeto Transform3DBuilder
     * <code>this</code>
     */
    public Transform3DBuilder rotY(double y) {
        final Transform3D tmp = new Transform3D();
        tmp.rotY(Math.toRadians(y));
        transform3D.mul(tmp);
        return this;
    }

    /**
     * Agrega la rotacion en el eje Z los grados que se indiquen al transform3D.
     * La rotacion se pasa en grados, rotZ de Trasnform3D requiere los grados en
     * radianes asi que internamente se hace una conversion.
     *
     * Ejecuta el metodo mul del objeto Transform3D global pasando como
     * parametro un Transform3D temporal.
     *
     * <code>
     *  final Transform3D tmp = new Transform3D();
     *  tmp.rotZ(Math.toRadians(z));
     *  transform3D.mul(tmp);
     * </code>
     *
     * @param z grados para rotar en el eje z.
     * @return una instancia del mismo objeto Transform3DBuilder
     * <code>this</code>
     */
    public Transform3DBuilder rotZ(double z) {
        final Transform3D tmp = new Transform3D();
        tmp.rotZ(Math.toRadians(z));
        transform3D.mul(tmp);
        return this;
    }

    /**
     * Retorna el transform3D global con todas las transformaciones que se le
     * agregaron.
     *
     * @return <code>transform3D</code>
     */
    public Transform3D getTransform3D() {
        return transform3D;
    }

}
