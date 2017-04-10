<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:draw="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"
                xmlns:text="urn:oasis:names:tc:opendocument:xmlns:text:1.0"
                xmlns:style="urn:oasis:names:tc:opendocument:xmlns:style:1.0"
                xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
                exclude-result-prefixes="draw text style office">
    <xsl:output method="xml" indent="yes" />
    <xsl:variable name="page" select="/office:document/office:body/office:drawing/draw:page"/>

    <xsl:template match="/office:document">
        <graph>
            <points>
                <xsl:apply-templates select="$page/draw:custom-shape">
                   <!-- <xsl:sort select="substring(@draw:id,3)" data-type="number" /> -->
                </xsl:apply-templates>
            </points>
            <rays>
                <xsl:apply-templates select="$page/draw:connector"/>
            </rays>
        </graph>
    </xsl:template>
    <xsl:template match="draw:connector">
        <xsl:variable name="statement"
                      select="/office:document/office:automatic-styles/style:style[@style:name=current()/@draw:style-name]/style:graphic-properties"/>
        <xsl:choose>
            <xsl:when test="$statement[@draw:marker-end and @draw:marker-start]">
                <ray>
                    <start>
                        <xsl:value-of select="@draw:start-shape"/>
                    </start>
                    <end>
                        <xsl:value-of select="@draw:end-shape"/>
                    </end>
                </ray>
                <ray>
                    <start>
                        <xsl:value-of select="@draw:end-shape"/>
                    </start>
                    <end>
                        <xsl:value-of select="@draw:start-shape"/>
                    </end>
                </ray>
            </xsl:when>
            <xsl:when test="$statement[@draw:marker-end and not(@draw:marker-start)]">
                <ray>
                    <start>
                        <xsl:value-of select="@draw:start-shape"/>
                    </start>
                    <end>
                        <xsl:value-of select="@draw:end-shape"/>
                    </end>
                </ray>
            </xsl:when>
            <xsl:when test="$statement[not(@draw:marker-end) and @draw:marker-start]">
                <ray>
                    <start>
                        <xsl:value-of select="@draw:end-shape"/>
                    </start>
                    <end>
                        <xsl:value-of select="@draw:start-shape"/>
                    </end>
                </ray>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
    <xsl:template match="draw:custom-shape">
        <point oid="{@draw:id}" id="{position()}">
            <name>
                <xsl:value-of select="text:p"/>
            </name>
            <description>
                <xsl:value-of select="@draw:name"/>
            </description>
        </point>
    </xsl:template>
</xsl:stylesheet>