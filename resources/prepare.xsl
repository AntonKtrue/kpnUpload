<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xml" indent="yes" />
    <xsl:key name="points" match="/graph/points/point" use="name" />
    <xsl:variable name="unions" select="key('union','U')"/>
    <xsl:variable name="freerays" select=""

    <xsl:template match="/">
        <graph>
            <points>
                <xsl:apply-templates select="/graph/points/point[not(name='U')]">
                    <xsl:sort select="substring(@id,3)" data-type="number" />
                </xsl:apply-templates>
            </points>
            <rays>
                <xsl:apply-templates select="/graph/rays"/>
               <!-- <xsl:apply-templates select="/grap/rays/ray[not(key('union',start)) and not(key('union',end))]"/>-->
            </rays>
        </graph>
    </xsl:template>
    <xsl:template match="point[not(name='U')]">
            <point oid="{@id}" id="{position()}">
                <name>
                    <xsl:value-of select="name"/>
                </name>
                <description>
                    <xsl:value-of select="description"/>
                </description>
            </point>
    </xsl:template>
    <xsl:template match="rays">
        <debug>debug</debug>
        <xsl:for-each select="$unions">
            <debug>
                <xsl:value-of select="."/>
            </debug>
            <xsl:variable name="uid" select="."/>
            <xsl:for-each select="/graph/rays/ray[end=$uid]">
                <xsl:variable name="start" select="./start"/>
                <xsl:for-each select="/graph/rays/ray[start=$uid]">
                    <xsl:variable name="end" select="./end"/>
                    <xsl:if test="$start!=$end">
                    <ray>
                        <start>
                            <xsl:value-of select="$start"/>
                        </start>
                        <end>
                            <xsl:value-of select="$end"/>
                        </end>
                    </ray>
                    </xsl:if>
                </xsl:for-each>
            </xsl:for-each>
        </xsl:for-each>
    </xsl:template>
    <xsl:template match="ray[not(key('union',start)) and not(key('union',end))]">
        <ray>
            <start>
                <xsl:value-of select="start"/>
            </start>
            <end>
                <xsl:value-of select="end"/>
            </end>
        </ray>
    </xsl:template>

</xsl:stylesheet>