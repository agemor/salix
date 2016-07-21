package com.eigenic.salix.graphics;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.eigenic.salix.world.SxObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by HyunJun on 2016. 7. 21..
 */
public class SxRenderer {


    public PolygonSpriteBatch polygonBatch;
    public Viewport viewport;

    public SxRenderer(Viewport viewport) {
        polygonBatch = new PolygonSpriteBatch();
        this.viewport = viewport;
    }


    public void render(SxObject object, float delta) {

        SxObject currentNode = object;

        /**
         * 전체 트리를 뽑아서.
         *
         * 1. z-index로 정렬
         * 2. 랜더링되지 않는 객체 삭제
         */

        polygonBatch.begin();

        while (currentNode != null) {

            currentNode.box //render

            for (int i = 0; i < currentNode.children.size(); i++) {

            }


        }


        polygonBatch.end();

        object.draw(polygonBatch, delta);

    }

    private List<SxObject> generateStructure(SxObject object) {

        List<SxObject> structure = new LinkedList<SxObject>();


        generateStructure(object, new SxObject(), structure);

        return structure;
    }


    private static final double SIN30 = Math.sin(Math.PI / 6);
    private static final double COS30 = Math.cos(Math.PI / 6);

    /**
     * 구조 리스트 생성
     *
     * @param object
     * @param frame
     * @param structure
     */
    private void generateStructure(SxObject object, SxObject frame, List<SxObject> structure) {

        // 뷰포트 포함 드로우 영역 체크

        frame.x += object.x;
        frame.y += object.y;
        frame.z += object.z;
        frame.rotation += object.rotation;

        float px = projectX(frame.x, frame.z, frame.rotation);
        float py = projectY(frame.x, frame.y, frame.z, frame.rotation);

        object.depth = py;

        boolean insideX = px >= viewport.getScreenX() && px <= viewport.getScreenX() + viewport.getScreenWidth();
        boolean insideY = py >= viewport.getScreenY() && py <= viewport.getScreenY() + viewport.getScreenHeight();

        // 구조에 추가
        if (insideX && insideY)
            insertByDepth(structure, object);

        // TODO: 하위 항목 제너레이션

        for (int i = 0; i < object.children.size(); i++)
            generateStructure(object.children.get(i), frame, structure);

    }

    /**
     * 구조 리스트에 오브젝트를 뎁스를 기준으로 추가한다.
     * @param structure
     * @param object
     */
    private void insertByDepth(List<SxObject> structure, SxObject object) {
        int insertionIndex = getInsertionIndex(structure, object.depth, 0, structure.size());
        structure.add(insertionIndex, object);
    }

    /**
     * 바이너리 서치로 해당 뎁스의 인덱스를 구한다
     *
     * @param structure
     * @param depth
     * @param beginIndex
     * @param count
     * @return
     */
    private int getInsertionIndex(List<SxObject> structure, float depth, int beginIndex, int count) {

        if (count < 1)
            return beginIndex;

        int pivotIndex = beginIndex + count / 2;
        SxObject pivotObject = structure.get(pivotIndex);

        if (pivotObject.depth < depth)
            return getInsertionIndex(structure, depth, pivotIndex, count / 2);
        else if (pivotObject.depth > depth)
            return getInsertionIndex(structure, depth, beginIndex, count / 2);
        else
            return pivotIndex;
    }

    /**
     * x 좌표에 대한 isometric projection 값
     *
     * @param x
     * @param z
     * @param rotation
     * @return
     */
    private float projectX(float x, float z, float rotation) {
        return (float) (x * Math.cos(rotation) - z * Math.sin(rotation));
    }

    /**
     * y좌표에 대한 isometric projection 값
     *
     * @param x
     * @param y
     * @param z
     * @param rotation
     * @return
     */
    private float projectY(float x, float y, float z, float rotation) {
        return (float) (x * SIN30 * Math.sin(rotation) + y * COS30 + z * SIN30 * Math.cos(rotation));
    }


    private void updateProjection() {
    }


}
