<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:draw="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"
                xmlns:text="urn:oasis:names:tc:opendocument:xmlns:text:1.0"
                xmlns:style="urn:oasis:names:tc:opendocument:xmlns:style:1.0"
                xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
                exclude-result-prefixes="draw text style office"
                xmlns:util="http://www.springframework.org/schema/util">
    <xsl:output method="xml" indent="yes"/>
    <xsl:variable name="page" select="/office:document/office:body/office:drawing/draw:page"/>

    <xsl:template match="/office:document">
        <beans xmlns="http://www.springframework.org/schema/beans"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xsi:schemaLocation="http://www.springframework.org/schema/beans
                                   http://www.springframework.org/schema/beans/spring-beans.xsd
                                   http://www.springframework.org/schema/util
                                   http://www.springframework.org/schema/util/spring-util-2.5.xsd">
            <xsl:apply-templates select="$page/draw:custom-shape"><xsl:sort select="substring(@draw:id,3)" data-type="number"/></xsl:apply-templates>

            <xsl:call-template name="points"/>
            <util:list id="rays" value-type="Ray">
                <xsl:apply-templates select="$page/draw:connector"/>
            </util:list>
        </beans>
    </xsl:template>
    <xsl:template match="draw:connector" >
        <xsl:variable name="statement"
                      select="/office:document/office:automatic-styles/style:style[@style:name=current()/@draw:style-name]/style:graphic-properties"/>
        <xsl:choose>
            <xsl:when test="$statement[@draw:marker-end and @draw:marker-start]">
                <bean class="Ray">
                    <constructor-arg index="0">
                        <xsl:attribute name="ref">
                            <xsl:value-of select="@draw:start-shape"/>
                        </xsl:attribute>
                    </constructor-arg>
                    <constructor-arg index="1">
                        <xsl:attribute name="ref">
                            <xsl:value-of select="@draw:end-shape"/>
                        </xsl:attribute>
                    </constructor-arg>
                </bean>
                <bean class="Ray">
                    <constructor-arg index="0">
                        <xsl:attribute name="ref">
                            <xsl:value-of select="@draw:end-shape"/>
                        </xsl:attribute>
                    </constructor-arg>
                    <constructor-arg index="1">
                        <xsl:attribute name="ref">
                            <xsl:value-of select="@draw:start-shape"/>
                        </xsl:attribute>
                    </constructor-arg>
                </bean>
            </xsl:when>
            <xsl:when test="$statement[@draw:marker-end and not(@draw:marker-start)]">
                <bean class="Ray">
                    <constructor-arg index="0">
                        <xsl:attribute name="ref">
                            <xsl:value-of select="@draw:start-shape"/>
                        </xsl:attribute>
                    </constructor-arg>
                    <constructor-arg index="1">
                        <xsl:attribute name="ref">
                            <xsl:value-of select="@draw:end-shape"/>
                        </xsl:attribute>
                    </constructor-arg>
                </bean>
            </xsl:when>
            <xsl:when test="$statement[not(@draw:marker-end) and @draw:marker-start]">
                <bean class="Ray">
                    <constructor-arg index="0">
                        <xsl:attribute name="ref">
                            <xsl:value-of select="@draw:end-shape"/>
                        </xsl:attribute>
                    </constructor-arg>
                    <constructor-arg index="1">
                        <xsl:attribute name="ref">
                            <xsl:value-of select="@draw:start-shape"/>
                        </xsl:attribute>
                    </constructor-arg>
                </bean>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
    <xsl:template match="draw:custom-shape">
        <bean id="{@draw:id}" class="Point">
            <constructor-arg index="0">
                <xsl:attribute name="value">
                    <xsl:value-of select="@draw:id"/>
                </xsl:attribute>
            </constructor-arg>
            <constructor-arg index="1">
                <xsl:attribute name="value">
                    <xsl:value-of select="text:p"/>
                </xsl:attribute>
            </constructor-arg>
            <constructor-arg index="2">
                <xsl:attribute name="value">
                    <xsl:value-of select="@draw:name"/>
                </xsl:attribute>
            </constructor-arg>
        </bean>
    </xsl:template>
    <xsl:template name="points">
        <util:list id="points" value-type="Point">
            <xsl:for-each select="$page/draw:custom-shape">
                <xsl:sort select="substring(@draw:id,3)" data-type="number"/>
                <ref bean="{@draw:id}"/>
            </xsl:for-each>
        </util:list>
    </xsl:template>
</xsl:stylesheet>