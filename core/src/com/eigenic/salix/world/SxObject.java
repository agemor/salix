package com.eigenic.salix.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HyunJun on 2016. 7. 21..
 */
public class SxObject {

    // 인덱스 : 시스템이 관리
    public float depth;

    // Dimension
    public float width = 1, height = 1, length = 1;

    // Coordinates
    public float x = 0, y = 0, z = 0;

    // Rotation
    public float rotation = 0;

    // Color
    public Color color = Color.RED;


    public SxObject parent;

    public List<SxObject> children;

    public SxObject() {

        children = new ArrayList<SxObject>();

    }


}
