package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.Badges;

public interface BadgeService {
    Badges getFirstTimeBadge();

    Badges getFifthTimeBadge();

    Badges getTenthTimeBadge();

    Badges getTwentiethTimeBadge();
}
