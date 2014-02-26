package org.semanticweb.owlapi.registries;

/**
 * 
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapitools.profiles.OWLProfile;

import com.github.ansell.abstractserviceloader.AbstractServiceLoader;

/**
 * @author Peter Ansell p_ansell@yahoo.com
 */
public class OWLProfileRegistry extends AbstractServiceLoader<IRI, OWLProfile> {

    private static final OWLProfileRegistry instance = new OWLProfileRegistry();

    /**
     * @return A static, pre-initialized, instance of this registry.
     */
    public static OWLProfileRegistry getInstance() {
        return OWLProfileRegistry.instance;
    }

    public OWLProfileRegistry() {
        super(OWLProfile.class);
    }

    /**
     * clear all registered profiles
     */
    public void clearProfileFactories() {
        clear();
    }

    @Override
    public IRI getKey(final OWLProfile service) {
        return service.getIRI();
    }

    public OWLProfile getProfile(IRI key) {
        Collection<OWLProfile> collection = get(key);
        if (collection.isEmpty()) {
            return null;
        } else {
            return collection.iterator().next();
        }
    }

    /**
     * @return the list of profiles - changes will not be backed by the registry
     */
    public List<OWLProfile> getProfiles() {
        return new ArrayList<OWLProfile>(getAll());
    }

    /**
     * @param profile
     *        the profile to register
     */
    public void registerProfileFactory(final OWLProfile profile) {
        add(profile);
    }

    /**
     * @param profile
     *        the profile to remove
     */
    public void unregisterProfileFactory(final OWLProfile profile) {
        remove(profile);
    }
}
