/**
 * Copyright 2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.wandrell.tabletop.dreadball.build.dbx.DbxTeamBuilder;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamAssets;
import com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean.SponsorTeamPlayer;

/**
 * Controller for the DBX team building AJAX operations.
 * <p>
 * The team to be edited is stored as a session variable.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/builder/team/dbx")
public class ExampleEntityRestController {

    /**
     * Parameter name for the team.
     */
    private static final String PARAM_TEAM = "team";

    /**
     * DBX team building service.
     */
    @Autowired
    private DbxTeamBuilder      dbxTeamBuilderService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param service
     *            team builder service
     */
    public DbxTeamBuilderRestController(final DbxTeamBuilder service) {
        super();

        // TODO: Should give support for validating the team valoration

        dbxTeamBuilderService = checkNotNull(service,
                "Received a null pointer as team builder service");
    }

    /**
     * Adds a player to the team.
     * 
     * @param player
     *            data of the player to add
     * @param team
     *            team where the player will be added
     * @param errors
     *            results from binding
     * @return the team with the new player
     */
    @PostMapping(path = "/players", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam addPlayer(
            @RequestBody final SponsorTeamPlayer player,
            @SessionAttribute(PARAM_TEAM) @Valid final SponsorTeam team,
            final BindingResult errors) {
        final Integer maxUnits; // Maximum number of units allowed
        final Unit unit;        // Unit to add

        // TODO: Maybe the response status should change if the data is invalid
        if (!errors.hasErrors()) {
            maxUnits = getDbxTeamBuilderService().getMaxTeamUnits();

            // TODO: Instead of enforcing the maximum send a warning
            if (team.getPlayers().size() < maxUnits) {
                unit = getDbxTeamBuilderService().getUnit(
                        player.getTemplateName(),
                        team.getSponsor().getAffinityGroups());

                // TODO: Maybe the response status should change if the unit
                // does not exist
                if (unit != null) {
                    addPlayer(team, unit);
                }
            }
        }

        return team;
    }

    /**
     * Removes a player from the team.
     * 
     * @param player
     *            data of the player to remove
     * @param team
     *            team containing the player
     * @param errors
     *            results from binding
     * @return the team without the removed player
     */
    @DeleteMapping(path = "/players",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam removePlayer(
            @RequestBody final SponsorTeamPlayer player,
            @SessionAttribute(PARAM_TEAM) @Valid final SponsorTeam team,
            final BindingResult errors) {

        // TODO: Maybe the response status should change if the data is invalid
        if (!errors.hasErrors()) {
            team.removePlayer(player.getPosition());
        }

        return team;
    }

    /**
     * Sets the assets in the team.
     * 
     * @param assets
     *            the assets to set on the team
     * @param team
     *            the team where the dice will be set
     * @param errors
     *            results from binding
     * @return the team with the new assets set
     */
    @PutMapping(path = "/assets", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final SponsorTeam setAssets(
            @RequestBody final SponsorTeamAssets assets,
            @SessionAttribute(PARAM_TEAM) @Valid final SponsorTeam team,
            final BindingResult errors) {

        // TODO: Maybe the response status should change if the data is invalid
        if (!errors.hasErrors()) {
            team.setCheerleaders(assets.getCheerleaders());
            team.setCoachingDice(assets.getCoachingDice());
            team.setMediBots(assets.getMediBots());
            team.setSabotageCards(assets.getSabotageCards());
            team.setSpecialMoveCards(assets.getSpecialMoveCards());
            team.setWagers(assets.getWagers());
        }

        return team;
    }

    /**
     * Adds a unit to the team.
     * 
     * @param team
     *            team to add the unit
     * @param unit
     *            unit to add
     */
    private final void addPlayer(final SponsorTeam team, final Unit unit) {
        final Boolean unique;
        final Iterator<Unit> units;
        Boolean uniqueFound;

        if ((unit.getGiant()) || (unit.getMvp())) {
            unique = true;
        } else {
            unique = false;
        }

        if (unique) {
            uniqueFound = false;
            units = team.getPlayers().values().iterator();
            while ((!uniqueFound) && (units.hasNext())) {
                uniqueFound = units.next().getTemplateName()
                        .equals(unit.getTemplateName());
            }

            if (!uniqueFound) {
                team.addPlayer(unit);
            }
        } else {
            team.addPlayer(unit);
        }
    }

    /**
     * Returns the DBX team builder service.
     * 
     * @return the DBX team builder service
     */
    private final DbxTeamBuilder getDbxTeamBuilderService() {
        return dbxTeamBuilderService;
    }

}
